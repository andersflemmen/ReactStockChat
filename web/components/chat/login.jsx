var Login = React.createClass( {
 getInitialState: function(){
      return {
          username: sessionStorage.username
        };
     },

      handleSubmit: function(){ 
        var input = this.refs.user.value;
        if(input.trim() != ''){
        sessionStorage.username = input;
     //   this.setState({username: sessionStorage.username});
        }
        return;
      },

      logout: function(){
        sessionStorage.username = '';
        return;
},


    render: function(){
       
        if(! this.state.username){
        return(  <form className="loginForm" onSubmit={this.handleSubmit}>
                  <input type="text" placeholder="Type in username" ref="user" />
                  <input type="submit" value="Join chat" />
                  </form> );}
      
        else{        
        return(
        <div>
         <form className="logoutForm" onSubmit={this.logout}> 
             <input type="submit" value="Logout"/>
         </form>
           <MessageBox url="comments.json" pollInterval={1000} user={sessionStorage.getItem('username')}/>
        </div>
      
);
}
}
});