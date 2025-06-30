
import React, { useState, useEffect } from 'react';
import {
  getAllCustomers,
  getCustomerById,
  addCustomer
} from '../../services/CustomerService';

function CustomerManager() {
  const [customers, setCustomers] = useState([]);
  const [form, setForm] = useState({ customerId: '', fName: '', phone: '' });
  const [searchId, setSearchId] = useState('');

  useEffect(() => {
    fetchCustomers();
  }, []);

  const fetchCustomers = async () => {
    const data = await getAllCustomers();
    setCustomers(data);
  };

  const handleInputChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleAddCustomer = async () => {
    if (!form.customerId || !form.fName || !form.phone) {
      alert('אנא מלא את כל השדות');
      return;
    }
    await addCustomer(form);
    fetchCustomers();
    setForm({ customerId: '', fName: '', phone: '' });
  };

  const handleSearchById = async () => {
    const customer = await getCustomerById(searchId);
    setCustomers(customer ? [customer] : []);
  };

  return (
    <div className="container">
      <h2>ניהול לקוחות</h2>
      <form>
        <input type="text" name="customerId" placeholder="מזהה לקוח" value={form.customerId} onChange={handleInputChange} />
        <input type="text" name="fName" placeholder="שם" value={form.fName} onChange={handleInputChange} />
        <input type="text" name="phone" placeholder="טלפון" value={form.phone} onChange={handleInputChange} />
        <button type="button" onClick={handleAddCustomer}>הוסף לקוח</button>
      </form>

      <div style={{ marginTop: '2em' }}>
        <input type="text" placeholder="חפש לפי מזהה" value={searchId} onChange={(e) => setSearchId(e.target.value)} />
        <button onClick={handleSearchById}>חפש</button>
      </div>

      <table border="1" style={{ marginTop: '2em', width: '100%', textAlign: 'center' }}>
        <thead>
          <tr>
            <th>מזהה</th>
            <th>שם</th>
            <th>טלפון</th>
          </tr>
        </thead>
        <tbody>
          {customers.map((c) => (
            <tr key={c.customerId}>
              <td>{c.customerId}</td>
              <td>{c.fName}</td>
              <td>{c.phone}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default CustomerManager;
