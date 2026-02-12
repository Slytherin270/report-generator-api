# RabbitMQ Event Contracts

Exchange: `reporting.events` (topic)

## report.job.created
```json
{
  "eventId": "2c03f4f5-772f-47ca-8e39-f73f90e4ad52",
  "eventType": "report.job.created",
  "occurredAt": "2026-02-12T10:01:22Z",
  "correlationId": "e591c351-f3df-441b-b15f-562fd7d67a9c",
  "payload": {
    "jobId": "97a1f4bc-916d-4582-b2aa-fcf50c97843d",
    "orgId": "69a23ac6-7862-4f2f-8bf6-5d33767f2cc3",
    "userId": "87030baf-1bb4-4b08-aa4f-26e36ef68407",
    "originalFileKey": "uploads/org/user/job/input.csv",
    "requestedFormats": ["PDF", "XLSX"]
  }
}
```

## report.job.completed
```json
{
  "eventId": "ac537165-f6e9-423f-b7ac-abec2b306f49",
  "eventType": "report.job.completed",
  "occurredAt": "2026-02-12T10:01:30Z",
  "correlationId": "e591c351-f3df-441b-b15f-562fd7d67a9c",
  "payload": {
    "jobId": "97a1f4bc-916d-4582-b2aa-fcf50c97843d",
    "durationMs": 5300,
    "artifacts": [
      {"format": "PDF", "fileKey": "reports/job/report.pdf", "sizeBytes": 120443}
    ]
  }
}
```

## report.job.failed
```json
{
  "eventId": "0a810bc5-6b6b-4a89-bf0c-bd6f3cfaf596",
  "eventType": "report.job.failed",
  "occurredAt": "2026-02-12T10:01:30Z",
  "correlationId": "e591c351-f3df-441b-b15f-562fd7d67a9c",
  "payload": {
    "jobId": "97a1f4bc-916d-4582-b2aa-fcf50c97843d",
    "durationMs": 5300,
    "errorCode": "CSV_SCHEMA_INVALID",
    "errorMessage": "Missing header amount"
  }
}
```
