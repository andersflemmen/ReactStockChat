var StatsBox = React.createClass({
    getStats: function() {
              $.ajax({
                url: this.props.url,
                dataType: 'json',
                cache: false,
                success: function(data) {
                    this.setState({
                      stats: data,
                      top10: data.top_ten_commented
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
        return {stats: { top_ten_commented: [] }, top10: []};
    },  

    render: function() {

        var top10 = this.state.stats.top_ten_commented.map(function(stock) {
                        return (<li key={stock.symbol}>{stock.symbol} (<b>{stock.count}</b>)</li>);
                    }, this);

        return (
            <div className="panel panel-info ">
                <div className="panel-heading">
                    <h3 className="panel-title">
                        <b>Statinator</b>
                    </h3>
                </div>
                <br />
                <div>
                    <ul className="statsPadding">
                        <li>Number of comments: <b>{this.state.stats.num_comments}</b></li>
                        <li>Number of comments today: <b>{this.state.stats.num_comments_today}</b></li>
                        <li>Number of chat messages: <b>{this.state.stats.num_messages}</b></li>
                        <li>Number of chat messages today: <b>{this.state.stats.num_messages_today}</b></li>
                        <li>
                            Most popular stocks (comments):
                            <ol>
                                {top10}
                            </ol>
                        </li>
                    </ul>
                </div>
            </div>
        );
    }
});
