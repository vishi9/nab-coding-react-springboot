import React, {Component} from 'react';
import './App.css';
import Table from './components/Table'

class App extends Component {

    state = {};

    componentDidMount() {
        setInterval(this.respText, 250);
    }

    respText = () => {
        fetch('/api/getdata')
            .then(response => response.text())
            .then(data => {
                this.setState({data: JSON.parse(data)});
            });
    };
 
    	
    	render() {
    	    return (
    	      <div className="App">
    	      Crypto Currency Profit Chart
    	      <Table data={this.state.data}/>
    	      </div>
    	    );
    	  }
    
        

}
export default App;
