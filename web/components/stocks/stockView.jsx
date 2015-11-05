var StockView = React.createClass({
    render: function() {
        return (
            <div className="StockView">
                <div className="searchView">
                    <StockSearch/>
                </div>

                <div className="chatView">
                    <MessageBox/>
                </div>

                <div className="commentView">
                </div>


            </div>
        );
    }
});