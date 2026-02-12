CREATE TABLE IF NOT EXISTS report_artifacts (
  id UUID PRIMARY KEY,
  job_id UUID NOT NULL REFERENCES report_jobs(id),
  format VARCHAR(10) NOT NULL,
  file_key VARCHAR(512) NOT NULL,
  size_bytes BIGINT NOT NULL,
  created_at TIMESTAMPTZ NOT NULL DEFAULT now(),
  UNIQUE(job_id, format)
);
