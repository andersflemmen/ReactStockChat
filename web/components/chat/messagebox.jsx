
var MessageBox = React.createClass({

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
             comment.id = new Date().getTime();
             var comments = this.state.data;
             var newComments = comments.concat([comment]);
             this.setState({data: newComments});

             
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
             return {data: [], username: sessionStorage.username};
           },
          login: function(user){ 
            var input = user;
            if(input.trim() != ''){
            sessionStorage.username = input;
            this.setState({username: sessionStorage.username});
            }
            return;
      },

            logout: function(event){
            event.preventDefault();
            sessionStorage.username = '';
            this.setState({username: sessionStorage.username});
            return;
},
           
           componentDidMount: function(){
            this.loadCommentsFromServer();
            setInterval(this.loadCommentsFromServer, this.props.pollInterval);
           },
          render: function() {
              return(
              <div className="chat">

                <div className="messageBox panel panel-info pull-right">
           
                    <div className="chatHeader panel-heading">
                        <div className="row">
                            {this.state.username && (
                                <div className="col-sm-8">
                                    <h3 className="panel-title"><b>Username : {this.state.username}</b></h3> 
                                </div>
                            )}

                            {this.state.username && (
                                <div className="col-sm-4">
                                    <Login logout={this.logout} logoutText="Logout" username={this.state.username}/>
                                </div>
                            )}

                            {!this.state.username && (
                            <div>
                                <div className="col-sm-1"></div>

                                <div className="col-sm-10">
                                    <Login login={this.login} submitText="Join Chat"/>
                                </div>

                                <div className="col-sm-1"></div>
                            </div>
                            )}
                        </div>
                    </div>
                    <MessageList data={this.state.data}/>
                    <div className="chatBottom">
                        { this.state.username && (
                        <MessageForm onCommentSubmit={this.handleCommentSubmit} author={this.state.username} />
                        )}

                
                    </div>
                </div>
               </div>
             );
          }
       });
