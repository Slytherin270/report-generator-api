CREATE TABLE IF NOT EXISTS usage_metric_daily (
  date DATE NOT NULL,
  org_id UUID NOT NULL,
  reports_count INT NOT NULL,
  failures_count INT NOT NULL,
  avg_duration_ms BIGINT NOT NULL,
  PRIMARY KEY(date, org_id)
);
