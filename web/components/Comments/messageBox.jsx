var CommentBox = React.createClass({


        loadCommentsFromServer: function(){
          $.ajax({
             symbol: this.props.symbol,
             url: 'REST/comments/get/' + symbol,
             dataType: 'json',
             cache: false,
             success: function(data){
               console.log('url: ' +url)
                 this.setState({data: data});

             }.bind(this),
             error: function(xhr, status, err){
                console.error("error in load from server")
                 console.error(this.props.url, status, err.toString());
             }.bind(this)
          });
      },
      handleCommentSubmit: function(comment){
          var comments = this.state.data;
          var newComments = comments.concat([comment]);
          this.setState({data: newComments});
          var data = JSON.stringify(comment);

          /*
          var username = "test"
          var message = "testMessage"
          var symbol = "GOOG"
          var data = JSON.stringify({username: username, message: message, symbol: symbol});
          */

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
         this.loadCommentsFromServer();
         setInterval(this.loadCommentsFromServer, this.props.pollInterval);
        },
       render: function() {
           return(
             <div className="commentBox">
             <h1>Comments</h1>
             <CommentList data={this.state.data} />
             <CommentForm onCommentSubmit={this.handleCommentSubmit} />
             </div>
          );
       }
    });
