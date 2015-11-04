var Stock = React.createClass({
        render: function() {

          var date = (new Date(this.props.stock.utctime)).toString();
          var change = parseFloat((this.props.stock.price - this.props.initialStock.price) * 100 / this.props.stock.price).toFixed(4);
          var lastChange = parseFloat((this.props.stock.price - this.props.oldStock.price) * 100 / this.props.stock.price).toFixed(4);

          return (
            <div className="stock">
              <span><h3>{this.props.stock.name}</h3></span>
              <p><b>Price:</b> {this.props.stock.price}</p>
              <p><b>Symbol:</b> {this.props.stock.symbol}</p>
              <p><b>Ts:</b> {this.props.stock.ts}</p>
              <p><b>Type:</b> {this.props.stock.type}</p>
              <p><b>Time:</b> {date}</p>
              <p><b>Volume:</b> {this.props.stock.volume}</p>
              <p><b>Change since page was opened:</b> <span className={change > 0 ? "green" : change < 0 ? "red" : "yellow"}>{change}%</span></p>
              <p><b>Last change:</b> <span className={lastChange > 0 ? "green" : lastChange < 0 ? "red" : "yellow"}>{lastChange}%</span></p>
            </div>
          );
        }
});