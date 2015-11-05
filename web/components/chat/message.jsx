     var Comment = React.createClass({
           rawMarkup: function() {
             var rawMarkup = marked(this.props.children.toString(), {sanitize : true});
             return { __html: rawMarkup };
           },
              render: function() {
                 return(
                  <li className="comment">
                    <b className="commentAuthor">
                      {this.props.author}
                    </b>
                    <span>: {this.props.children} </span>
                  
                   </li>
                  //  <span dangerouslySetInnerHTML={this.rawMarkup()} /> 
              );
           }
       });