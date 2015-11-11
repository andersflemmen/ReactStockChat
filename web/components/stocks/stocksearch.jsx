var StockSearch = React.createClass({
    getInitialState: function() {
        return {
            value: 'GOOG'
        }
    },
    submit: function(event){
        event.preventDefault();
        var stockSymbol = ReactDOM.findDOMNode(this.refs.inputField).value.trim().toUpperCase();
        this.refs.stockbox.update("REST/stocks/single/" + stockSymbol);
        this.setState({value: stockSymbol});
        this.refs.inputField.value = "";
    },
    update: function(symbol){
      this.setState({commentSymbol: symbol});  
      this.refs.commentBox.refresh("REST/comments/get/" + symbol);
    }
    ,
    render: function(){
        return(
            <div>
                <div className="stockPanel center-block">
                    <StockBox url="REST/stocks/single/" symbol={this.state.value} pollInterval={10000} ref="stockbox" className="center-block" update={this.update}/>
                      <form onSubmit={this.submit}>
                        <div className="input-group">
                            <input type="text" ref="inputField" className="form-control" placeholder="Enter stock symbol..." />
                            <span className="input-group-btn">
                                <button type="submit" className="btn btn-primary" ><span className="glyphicon glyphicon-search"></span></button>
                            </span>
                        </div>  
                    </form>
                </div>
                <hr/>
                <div className="">       
                    <CommentBox loadUrl={"REST/comments/get/" + this.state.commentSymbol} pollInterval={1000} postUrl={"REST/comments/new/" + this.state.commentSymbol} ref="commentBox"/>
                </div>      
            </div>
        );
    }
});
