CREATE TABLE IF NOT EXISTS report_jobs (
  id UUID PRIMARY KEY,
  org_id UUID NOT NULL,
  user_id UUID NOT NULL,
  original_file_key VARCHAR(512) NOT NULL,
  status VARCHAR(20) NOT NULL,
  error_message TEXT,
  created_at TIMESTAMPTZ NOT NULL DEFAULT now(),
  started_at TIMESTAMPTZ,
  finished_at TIMESTAMPTZ
);
CREATE INDEX IF NOT EXISTS idx_report_jobs_org_created_at ON report_jobs(org_id, created_at DESC);
CREATE INDEX IF NOT EXISTS idx_report_jobs_user_created_at ON report_jobs(user_id, created_at DESC);
