      var MessageList = React.createClass({

           render: function() {
               var messageNodes = this.props.data.map(function (comment){
                  return (
                   <Message author={comment.username} postedTime={comment.postedTime}>
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