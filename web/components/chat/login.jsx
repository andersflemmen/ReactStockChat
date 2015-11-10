var Login = React.createClass( {
    login: function(event) {
        event.preventDefault();
        var input = this.refs.user.value;
        this.props.login(input);
        return;
},


    render: function(){ 
       
        if(! this.props.username){
        return(  <form className="loginForm" onSubmit={this.login}>
                  <input type="text" placeholder="Type in name" ref="user" />
                  <input type="submit" value={this.props.submitText} />
                  </form> );}
      
        else{       
        return(
         <form className="logoutForm" onSubmit={this.props.logout}> 
             <input type="submit" value={this.props.logoutText}/>
         </form>
      
);
}
}
});