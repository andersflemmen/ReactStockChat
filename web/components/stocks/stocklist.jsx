var StockList = React.createClass({
        render: function() {

          var stockNodes = this.props.stocks.map(function (stock, index) {
            return (
              <Stock stock={stock}/>
            );
          });

          return (
            <div className="">
              {stockNodes}
            </div>
          );
        }
});