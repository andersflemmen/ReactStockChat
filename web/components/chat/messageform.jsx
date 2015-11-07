    var MessageForm = React.createClass({
           handleSubmit: function(e){
               e.preventDefault();
               var text = this.refs.text.value.trim();
               if(!text){
                   return;
               }
               this.props.onCommentSubmit({username: this.props.author, message: text});
               this.refs.text.value = '';
               return;
           },
           
           render: function() {
               return(
                  <form className="messageForm" onSubmit={this.handleSubmit}>
                  <input type="text" placeholder="Write something" ref="text" />
                  <input type="submit" value="Post" />
                  </form>
                );
           }
       });