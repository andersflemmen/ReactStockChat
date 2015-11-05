var StockBox = React.createClass({

        loadCommentsFromServer: function() {
          $.ajax({
            url: this.props.url,
            dataType: 'json',
            cache: false,
            success: function(data) {
                this.setState({
                  stocks: data.resources,
                });

            }.bind(this),
            error: function(xhr, status, err) {
              console.error(this.props.url, status, err.toString());
            }.bind(this)
          });
        },

        getInitialState: function() {
          return {stocks: []};
        },

        componentDidMount: function() {
          this.loadCommentsFromServer();
          setInterval(this.loadCommentsFromServer, this.props.pollInterval);
        },

        render: function() {
          return (
            <div className="stockBox">
              <h1>Currencies</h1>
              <StockList stocks={this.state.stocks} />
            </div>
          );
        }
});