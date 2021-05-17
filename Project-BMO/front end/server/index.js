const express = require('express');
const cors = require('cors');
const xml2json = require('xml2json')

require('dotenv').config()
const axios = require('axios');

const app = express();
const port = 3000;
app.use(cors())
app.use(express.json())

app.get('/', (req, res) => {
    res.send('Hey, Application Service here');
});


app.post('/zip4', async (req, res) => {
    const { address, address1, city, state, zip } = req.body;
    const BASE_URI = 'http://production.shippingapis.com/ShippingAPITest.dll?API=ZipCodeLookup'
    const xml = `
      <ZipCodeLookupRequest USERID=${process.env.USER_ID}>
        <Address ID="1">
            <Address1>${address}</Address1>
            <Address2>${address1}</Address2>
            <City>${city}</City>
            <State>${state}</State>
            <Zip5>${zip}</Zip5>
            <Zip4></Zip4>
        </Address>
      </ZipCodeLookupRequest>
      `
    const url = `${BASE_URI}&XML=${encodeURIComponent(xml)}`
    let { body } = await axios.get(url)
    return JSON.parse(xml2json.toJson(body))
});

app.listen(port, () => `Server started successfully at ${port}`);