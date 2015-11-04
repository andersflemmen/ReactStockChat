var StockBox = React.createClass({

        loadCommentsFromServer: function() {
          $.ajax({
            url: this.props.url,
            dataType: 'json',
            cache: false,
            success: function(data) {
              if (this.state.initial) {
                this.setState({
                  oldStocks: data.list.resources,
                  stocks: data.list.resources,
                  initialStocks: data.list.resources,
                  initial: false
                });
              } else {
                this.setState({
                  oldStocks: this.state.stocks,
                  stocks: data.list.resources
                });
              }
            }.bind(this),
            error: function(xhr, status, err) {
              console.error(this.props.url, status, err.toString());
            }.bind(this)
          });
        },

        getInitialState: function() {
          return {stocks: [], oldStocks: [], initialStocks: [], initial: true};
        },

        componentDidMount: function() {
          this.loadCommentsFromServer();
          setInterval(this.loadCommentsFromServer, this.props.pollInterval);
        },

        render: function() {
          return (
            <div className="stockBox">
              <h1>Stocks</h1>
              <StockList stocks={this.state.stocks} oldStocks={this.state.oldStocks} initialStocks={this.state.initialStocks} />
            </div>
          );
        }
});