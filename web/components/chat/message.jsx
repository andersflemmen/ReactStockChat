     var Message = React.createClass({
       componentDidMount: function() {
        this.refs.message.scrollIntoView('false');
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