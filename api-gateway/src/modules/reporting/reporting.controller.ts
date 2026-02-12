import { Controller, Get, Param, Post, Query } from '@nestjs/common';

@Controller('reports')
export class ReportingProxyController {
  @Post('jobs')
  createJob() {
    return { message: 'Proxy multipart upload to reporting-service /reports/jobs' };
  }

  @Get('jobs/:jobId')
  getJob(@Param('jobId') jobId: string) {
    return { message: 'Proxy to reporting-service /reports/jobs/{jobId}', jobId };
  }

  @Get('history')
  history(@Query() query: Record<string, string>) {
    return { message: 'Proxy to reporting-service /reports/history', query };
  }
}
