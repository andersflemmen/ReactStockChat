     var Message = React.createClass({
       componentDidMount: function() {
       var msg = this.refs.message;
            msg.parentNode.scrollTop = msg.offsetTop;
    },
              render: function() {
   var date = (new Date(this.props.postedTime)).toLocaleString();
                 return(
                  <li className="message" ref="message">
                  
                            
                    <span title={date} className="messageTime"  >
                        <b className="commentAuthor">
                             {this.props.author}
                        </b>
                    </span>
                    <span>: {this.props.children} </span>
                  
                   </li>
               
              );
           }
       });