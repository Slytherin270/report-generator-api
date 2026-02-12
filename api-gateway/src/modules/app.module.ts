import { Module } from '@nestjs/common';
import { AuthProxyController } from './auth/auth.controller';
import { ReportingProxyController } from './reporting/reporting.controller';

@Module({
  controllers: [AuthProxyController, ReportingProxyController]
})
export class AppModule {}
