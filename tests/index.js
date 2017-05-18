var HOST = 'http://localhost:8080';
 
var agent = require('supertest').agent(HOST);
var assert = require('assert');
 
 
describe('Simple API test', function() {
 
    it('Get Tag', function(done) {
 
        agent.get('/tags/VIP')
            .expect(200);
		done();
    });
});