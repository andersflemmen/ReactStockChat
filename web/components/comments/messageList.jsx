var MessageList = React.createClass({
     render: function() {
         var messageNodes = this.props.data.map(function (m){
            return (
             <Message author={m.username}>
             {m.message}
             </Message>
          );
         });

         return (
            <ul className="messageList">
            {messageNodes}
            </ul>
          );
     }
 });
