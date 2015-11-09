var Stock = React.createClass({
        render: function() {

          var date = (new Date(this.props.stock.utctime)).toLocaleString();

          return (
            <div className="panel panel-info pull-left stockPanel">
                <div className="panel-heading">
                    <h3 className="panel-title">
                        <b>{this.props.stock.name}</b>
                    </h3>
                </div>
                <div className="panel-body">
                    <table className="stockPanelTable" >
                        <tbody>
                        <col width="50%" />
                        <col width="50%" />
                        <tr>
                            <td>
                                <div className="">
                                    <ul className="list-group">
                                        <li className="list-group-item "><b>Price:</b> {this.props.stock.price}</li>
                                        <li className="list-group-item "><b>Symbol:</b> {this.props.stock.symbol}</li>
                                        <li className="list-group-item "><b>Volume:</b> {this.props.stock.volume}</li>
                                        <li className="list-group-item "><b>Type:</b> {this.props.stock.type}</li>
                                        <li className={this.props.stock.chg_percent > 0 ? "list-group-item list-group-item-success" : this.props.stock.chg_percent < 0 ? "list-group-item list-group-item-danger" : "list-group-item list-group-item-warning"}><b>Change in %:</b> <span>{this.props.stock.chg_percent}%</span></li>
                                    </ul>
                                </div>
                            </td>
                            <td>
                                <div className="">
                                    <ul className="list-group">
                                        <li className="list-group-item list-group-item list-group-item-success"><b>Day High:</b> {this.props.stock.day_high}</li>
                                        <li className="list-group-item list-group-item list-group-item-danger"><b>Day Low:</b> {this.props.stock.day_low}</li>
                                        <li className="list-group-item list-group-item list-group-item-success"><b>Year High:</b> {this.props.stock.year_high}</li>
                                        <li className="list-group-item list-group-item list-group-item-danger"><b>Year Low:</b> {this.props.stock.year_low}</li>
                                        <li className={this.props.stock.change > 0 ? "list-group-item list-group-item-success" : this.props.stock.change < 0 ? "list-group-item list-group-item-danger" : "list-group-item list-group-item-warning"}><b>Change:</b> <span>{this.props.stock.change}</span></li>
                            
                                    </ul>
                                </div>
                            </td>
                        </tr>
                    </tbody>
                    </table>                            
                    <p className=""><b>Last updated:</b> {date}</p>
                </div>
            </div>
          );
        }
});
