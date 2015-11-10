var StockSearch = React.createClass({
    getInitialState: function() {
        return {
            value: 'GOOG'
        }
    },
    submit: function(event){
        event.preventDefault();
        var stockSymbol = React.findDOMNode(this.refs.inputField).value.trim();
        this.setState({value: stockSymbol});
        this.refs.stockbox.update("REST/stocks/single/" + stockSymbol);
    },
    render: function(){
        return(
            <div className="stockPanel">
                <StockBox url={"REST/stocks/single/" + this.state.value} pollInterval={10000} ref="stockbox" />
                <form onSubmit={this.submit}>
                    <div className="input-group">
                        <input type="text" ref="inputField" className="form-control" placeholder="Enter stock symbol..." />
                        <span className="input-group-btn">
                            <button type="submit" className="btn btn-primary" ><span className="glyphicon glyphicon-search"></span></button>
                        </span>
                    </div>  
                </form>
            </div>
        );
    }
});