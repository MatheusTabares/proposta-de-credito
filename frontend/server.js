var express = require('express');
var app = express();

app.set('port', (5000));

require('./config/express')(app);

app.listen(app.get('port'), function() {
  console.log('Node app is running on port', app.get('port'));
});