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
            <div>
                <form onSubmit={this.submit}>
                    <input type="text" name="search" ref="inputField"/>
                    <input type="submit" value="Request" />
                </form>
                <StockBox url={"REST/stocks/single/" + this.state.value} pollInterval={10000} ref="stockbox" />
 
                     
             <CommentBox loadUrl={"REST/comments/get/" + this.state.value} pollInterval={1000} postUrl={"REST/comments/new/" + this.state.value}/>
                     
            </div>
        );
    }
});