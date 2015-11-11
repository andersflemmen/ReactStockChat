      var MessageList = React.createClass({

           render: function() {
               var messageNodes = this.props.data.map(function (comment){
                  return (
                   <Message key={comment.id} author={comment.username} postedTime={comment.postedTime} >
                   {comment.message}
                   </Message>
                ); 
               });
                       
               return (
                    <div className="messageList">
                        {messageNodes}
                    </div>
                );
           }
       });