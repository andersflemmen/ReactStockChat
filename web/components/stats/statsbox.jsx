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
                        return (<li key={stock.symbol}>{stock.symbol} ({stock.count})</li>);
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
                        <li>Number of comments: {this.state.stats.num_comments}</li>
                        <li>Number of comments today: {this.state.stats.num_comments_today}</li>
                        <li>Number of chat messages: {this.state.stats.num_messages}</li>
                        <li>Number of chat messages today: {this.state.stats.num_messages_today}</li>
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
