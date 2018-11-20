import React, { Component } from 'react';
import {BootstrapTable, 
       TableHeaderColumn} from 'react-bootstrap-table';
import '../css/Table.css'
import '../../node_modules/react-bootstrap-table/css/react-bootstrap-table.css'

 
 
class Table extends Component {
  render() {
    return (
      <div className="data-table">
        <BootstrapTable data={this.props.data}>
          <TableHeaderColumn isKey dataField='currency'>
            CURRENCY
          </TableHeaderColumn>
          <TableHeaderColumn dataField='profit'>
            PROFIT
          </TableHeaderColumn>
          <TableHeaderColumn dataField='minTs'>
            Buy Time
          </TableHeaderColumn>
          <TableHeaderColumn dataField='maxTs'>
            Sell Time
          </TableHeaderColumn>
        </BootstrapTable>
      </div>
    );
  }
}
 
export default Table;