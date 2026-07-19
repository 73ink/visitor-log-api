# Visitor Log API

Visitor Log API is a simple Spring Boot REST API used to record visitors at a training center front desk.  
The project stores visitor data in memory using a Java List, so the data resets when the application restarts.

## Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/health` | Check API health |
| GET | `/api/visitors` | Get all visitors |
| GET | `/api/visitors/{id}` | Get visitor by ID |
| POST | `/api/visitors` | Add a new visitor |
| PUT | `/api/visitors/{id}` | Update visitor by ID |
| DELETE | `/api/visitors/{id}` | Delete visitor by ID |
| GET | `/api/visitors/count` | Get total number of visitors |
| GET | `/api/visitors?purpose=meeting` | Filter visitors by purpose |

## Example POST Body

```json
{
  "name": "Ahmed Al Balushi",
  "company": "Codeline",
  "purpose": "meeting"
}