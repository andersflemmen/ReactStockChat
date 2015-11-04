var StockList = React.createClass({
        render: function() {

          var oldStocks = this.props.oldStocks;
          var initialStocks = this.props.initialStocks;

          var stockNodes = this.props.stocks.map(function (stock, index) {
            return (
              <Stock stock={stock.resource.fields}
              oldStock={oldStocks[index].resource.fields}
              initialStock={initialStocks[index].resource.fields} />
            );
          });

          return (
            <div className="commentList">
              {stockNodes}
            </div>
          );
        }
});