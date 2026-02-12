# API Summary

Base URL (gateway): `/api/v1`

## Auth
- `POST /auth/signup`
- `POST /auth/login`
- `POST /auth/refresh`
- `POST /auth/logout`
- `GET /auth/me`

## Admin
- `POST /admin/organizations`
- `PATCH /admin/organizations/{orgId}/status`
- `PATCH /admin/users/{userId}/status`

## Organization
- `GET /orgs/{orgId}/users`

## Reporting
- `POST /reports/jobs` (multipart CSV upload)
- `GET /reports/jobs/{jobId}`
- `GET /reports/history`
- `GET /orgs/{orgId}/reports/history`
- `GET /reports/analytics/summary`
- `GET /reports/analytics/timeseries`
- `GET /reports/analytics/top-employees`
- `POST /reports/artifacts/{artifactId}/download-token`
- `GET /reports/artifacts/download?token=...`

## Pagination and sorting
Use query params:
- `page` (default 0)
- `size` (default 20, max 100)
- `sort` format: `field,asc|desc`

## Error format
`application/problem+json`
