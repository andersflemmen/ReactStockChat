var CommentList = React.createClass({
     render: function() {
         var commentNodes = this.props.data.map(function (comment){
            return (
             <Comment author={comment.username}>
             {comment.message}
             </Comment>
          );
         });

         return (
            <ul className="commentList">
            {commentNodes}
            </ul>
          );
     }
 });
