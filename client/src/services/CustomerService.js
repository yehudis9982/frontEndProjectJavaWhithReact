
const API_URL = 'http://localhost:8080/customer';

export const getAllCustomers = async () => {
  const res = await fetch(`${API_URL}/getAll`);
  return res.json();
};

export const getCustomerById = async (id) => {
  const res = await fetch(`${API_URL}/getById/${id}`);
  return res.json();
};

export const addCustomer = async (customer) => {
  const res = await fetch(`${API_URL}/add`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(customer)
  });
  return res.json();
};
