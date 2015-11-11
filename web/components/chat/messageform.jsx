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
                    <form onSubmit={this.handleSubmit}>
                        <div className="input-group chatInput">
                            <input type="text" ref="text" className="form-control" placeholder="Write something" />
                            <span className="input-group-btn ">
                                <button type="submit" className="btn btn-primary" ><span className="glyphicon glyphicon-comment"></span></button>
                            </span>
                        </div>  
                    </form>
                );
           }
       });