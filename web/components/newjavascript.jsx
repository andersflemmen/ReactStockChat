var StockList = React.createClass({
        render: function() {

          var stockNodes = this.props.stocks.map(function (stock, index) {
            return (
              <Stock stock={stock} key={stock.symbol}/>
            );
          });

          return (
            <div className="">
              {stockNodes}
            </div>
          );
        }
});
