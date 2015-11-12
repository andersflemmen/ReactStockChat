var StockBox = React.createClass({

        loadCommentsFromServer: function() {
          $.ajax({
            url: this.props.url + this.props.symbol,
            dataType: 'json',
            cache: false,
            success: function(data) {
                this.setState({
                  stocks: data.resources,
                });
                
                if(data.resources.length > 0 && this.props.update){
                    this.props.update(this.props.symbol)
                }

            }.bind(this),
            error: function(xhr, status, err) {
              console.error(this.props.url, status, err.toString());
            }.bind(this)
          });
        },

        update: function(url) {
            $.ajax({
            url: url,
            dataType: 'json',
            cache: false,
            success: function(data) {
                this.setState({
                  stocks: data.resources,
                });

                if(data.resources.length > 0){
                    this.props.update(this.props.symbol)
                }

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
              <StockList stocks={this.state.stocks} />
            </div>
          );
        }
});
