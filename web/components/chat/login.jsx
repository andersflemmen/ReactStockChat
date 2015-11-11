var Login = React.createClass( {
    login: function(event) {
        event.preventDefault();
        var input = this.refs.user.value;
        this.props.login(input);
        return;
},


    render: function(){ 
       
        if(! this.props.username){
        return(  
            <form onSubmit={this.login} className="">
                <div className="input-group">
                    <input type="text" ref="user" className="form-control" placeholder="Choose username" />
                    <span className="input-group-btn">
                        <button type="submit" className="btn btn-primary" ><span className="glyphicon glyphicon-log-in"></span></button>
                    </span>
                </div>
            </form>
            );
        }
        else{       
        return(

        <form onSubmit={this.props.logout} className="">
            <div className="input-group">
                <button type="submit" className="btn btn-primary" >{this.props.logoutText} <span className="glyphicon glyphicon-log-out"></span></button>
            </div>  
        </form>
      
);
}
}
});