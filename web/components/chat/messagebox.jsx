   var CommentBox = React.createClass({

           loadCommentsFromServer: function(){
             $.ajax({
                url: 'REST/messages/last',
                dataType: 'json',
                cache: false,
                success: function(data){
                    this.setState({data: data});
                }.bind(this),
                error: function(xhr, status, err){
                    console.error(this.props.url, status, err.toString());
                }.bind(this)
             });
         },
         handleCommentSubmit: function(comment){
             var comments = this.state.data;
             var newComments = comments.concat([comment]);
             this.setState({data: newComments});
             var data = JSON.stringify(comment);
           $.ajax({
               url: 'REST/messages/new/',
               contentType: 'application/json; charset=utf-8',
               dataType: 'json',
               type: 'POST',
               data: data,
               success: function(){

               }.bind(this),
               error: function(xhr, status, err){
                   console.error(this.props.url, status, err.toString());
               }.bind(this)
           });
         },
           getInitialState: function() {
             return {data: []};
           },
           componentDidMount: function(){
            this.loadCommentsFromServer();
            setInterval(this.loadCommentsFromServer, this.props.pollInterval);
           },
          render: function() {
              return(
                <div className="commentBox">
                <h1>Comments</h1>
                <CommentList data={this.state.data} />
                <CommentForm onCommentSubmit={this.handleCommentSubmit} />
                </div>
             );
          }
       });
