var MessageBox = React.createClass({

        loadMessagesFromServer: function(){
          $.ajax({
             symbol: this.props.symbol,
             url: 'REST/comments/get/' + symbol,
             dataType: 'json',
             cache: false,
             success: function(data){
                 this.setState({data: data});

             }.bind(this),
             error: function(xhr, status, err){
                console.error("error in load from server")
                 console.error(this.props.url, status, err.toString());
             }.bind(this)
          });
      },
      handleMessageSubmit: function(message){
          message.symbol = this.props.symbol;
          var messages = this.state.data;
          var newMessages = messages.concat([message]);
          this.setState({data: newMessages});
          var data = JSON.stringify(message);

        $.ajax({
            url: 'REST/comments/new/',
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            type: 'POST',
            data: data,
            success: function(){

            }.bind(this),
            error: function(xhr, status, err){
                console.error(this.props.url, status, err.toString());
            }.bind(this)
        });
      },
        getInitialState: function() {
          return {data: []};
        },
        componentDidMount: function(){
         this.loadMessagesFromServer();
         setInterval(this.loadMessagesFromServer, this.props.pollInterval);
        },
       render: function() {
           return(
             <div className="messageBox">
             <h3>Messages</h3>
             <MessageList data={this.state.data} />
             <MessageForm onMessageSubmit={this.handleMessageSubmit} />
             </div>
          );
       }
    });
