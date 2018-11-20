import React, { Component } from 'react';
import {BootstrapTable, 
       TableHeaderColumn} from 'react-bootstrap-table';
import '../css/Table.css'
import '../../node_modules/react-bootstrap-table/css/react-bootstrap-table.css'

 
 
class TableFile extends Component {
  render() {
    return (
      <div className="data-table">
			<strong>Crypto Currency Chart</strong>
        <BootstrapTable data={this.props.data}>
          <TableHeaderColumn isKey dataField='Currency'>
            CURRENCY
          </TableHeaderColumn>
          <TableHeaderColumn dataField='Date'>
            Date
          </TableHeaderColumn>
          <TableHeaderColumn dataField='Time'>
           Time
          </TableHeaderColumn>
          <TableHeaderColumn dataField='Price'>
            Price
          </TableHeaderColumn>
        </BootstrapTable>
      </div>
    );
  }
}
 
export default TableFile;