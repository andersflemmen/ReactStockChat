     var Message = React.createClass({
       componentDidMount: function() {
       if(! this.props.dontScroll){
       var msg = this.refs.message;
           msg.parentNode.scrollTop = msg.offsetTop;
            
}
    },
              render: function() {
                 return(
                  
                    <div className="row" ref="message">
                        <div className="col-sm-1">
                        </div>

                        <div className="col-sm-10">
                            <div className="panel panel-default">
                                <div className="panel-heading">
                                
                                    <div className="row">
                                        <div className="col-sm-12 pull-left">
                                            <span><b>{this.props.author} </b></span>
                                        </div>
                                    </div>

                                    <div className="row">
                                        <div className="col-sm-12">
                                            <span className="text-muted messageText" >{this.props.children}</span>
                                        </div>
                                    </div>
                                    
                                    <div className="row">
                                        <div className="col-sm-12 pull-right">
                                            <span className="text-muted pull-right"> {timeDifference(new Date(), new Date(this.props.postedTime))}</span> <span className="pull-right text-muted glyphicon glyphicon-time" ></span>                             
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>

                        <div className="col-sm-1">
                        </div>

                    </div>     
               
              );
           }
       });