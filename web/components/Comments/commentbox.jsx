var CommentBox = React.createClass({
           loadCommentsFromServer: function(){
             $.ajax({
                url: this.props.loadUrl,
                dataType: 'json',
                cache: false,
                success: function(data){
                    this.setState({data: data});
                }.bind(this),
                error: function(xhr, status, err){
                    console.error(this.props.loadUrl, status, err.toString());
                }.bind(this)
             });
         },
         handleCommentSubmit: function(comment){

             var data = JSON.stringify(comment);
           $.ajax({
               url: this.props.postUrl,
               contentType: 'application/json; charset=utf-8',
               dataType: 'json',
               type: 'POST',
               data: data,
               success: function(){

               }.bind(this),
               error: function(xhr, status, err){
                   console.error(this.props.postUrl, status, err.toString());
               }.bind(this)
           });
         },
           getInitialState: function() {
             return {data: [], username: sessionStorage.user};
           },
          login: function(user){ 
            var input = user;
            if(input.trim() != ''){
            sessionStorage.user = input;
            this.setState({username: sessionStorage.user});
            }
            return;
      },

            logout: function(event){
            event.preventDefault();
            sessionStorage.user = '';
            this.setState({username: sessionStorage.user});
            return;
},
           
           componentDidMount: function(){
            this.loadCommentsFromServer();
            setInterval(this.loadCommentsFromServer, this.props.pollInterval);
           },

          render: function() {
              return(
                <div className="commentBox">
                
              { !this.state.username && (<Login login={this.login} submitText="Set name" />)}

              {  this.state.username && ( 
              <div>
              <br/>
              <br/>
              <Login logout={this.logout} username={this.state.username} logoutText="Change name" /> 
                <div className="commentForm">
                 <MessageForm onCommentSubmit={this.handleCommentSubmit} author={this.state.username} />
                </div>
                </div>)
                }
                <MessageList data={this.state.data} />
            
                </div>
             );
          }
       });
