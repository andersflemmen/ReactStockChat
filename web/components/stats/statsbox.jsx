var StatsBox = React.createClass({
    getStats: function() {
              $.ajax({
                url: url,
                dataType: 'json',
                cache: false,
                success: function(data) {
                    this.setState({
                      stats: data,
                    });
                }.bind(this),
                error: function(xhr, status, err) {
                  console.error(this.props.url, status, err.toString());
                }.bind(this)
              });
    },

    componentDidMount: function() {
        setInterval(this.getStats, this.props.pollInterval);
        this.getStats();
    },

    getInitialState: function() {
        return {stats: []};
    },  

    render: function() {

        return (
            <div className="panel panel-info pull-left stockPanel">
                <div className="panel-heading">
                    <h3 className="panel-title">
                        <b>My favorite stocks</b>
                    </h3>
                </div>
                
                    <form onSubmit={this.addStock}>
                            <div className="input-group">
                              <input type="text" ref="stockInput" className="form-control" placeholder="Enter stock symbol..." />
                              <span className="input-group-btn">
                                <button type="button" className="btn btn-primary">Add</button>
                              </span>
                            </div>
                    </form>
                <table className="table">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Change in %</th>
                        </tr>
                    </thead>
                    <tbody>
                        {stockNodes}
                    </tbody>
                </table>
            </div>
        );
    }
});
