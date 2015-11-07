var Message = React.createClass({
         render: function() {
            return(
             <li className="message">
               <b className="messageAuthor">
                 {this.props.author}
               </b>
               <span>: {this.props.children} </span>

              </li>

         );
      }
  });
