var StockView = React.createClass({
    render: function() {
        return (
            <div className="StockView">
                <div className="chatAndStock">
                
                    <div className="searchView">
                        <StockSearch/>
                    </div>

                    <div className="chatView pull-right">
                        <CommentBox url="REST/messages/last" pollInterval={1000}/>
                    </div>

                    <div className="chatAndStock">
                    </div>

                </div>
            </div>
        );
    }
});