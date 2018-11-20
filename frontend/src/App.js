import React, {Component} from 'react';
import './App.css';

import Table from './components/Table'



import TableFile from './components/TableFile'

class App extends Component {

    state = {};

    componentDidMount() {
        setInterval(this.priceJson, 250);
        setInterval(this.responseData, 250);
    }

    priceJson = () => {
        fetch('/api/getjson')
            .then(response => response.text())
            .then(json => {
                this.setState({json: JSON.parse(json)});
            })
    };
    
    responseData = () => {
        fetch('/api/getdata')
            .then(response => response.text())
            .then(data => {
                this.setState({data: JSON.parse(data)});
            });
    };
    	
    	render() {
    	    return (
    	      <div className="App">
	    	      <TableFile data={this.state.json}></TableFile>
	    	     
	    	      <Table data={this.state.data}></Table>
    	      </div>
    	    );
    	  }
    
        

}
export default App;
