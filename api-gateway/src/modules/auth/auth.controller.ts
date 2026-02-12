import { Body, Controller, Get, HttpCode, Post, Req } from '@nestjs/common';

@Controller('auth')
export class AuthProxyController {
  @Post('signup')
  signup(@Body() body: unknown) {
    return { message: 'Proxy to auth-service /auth/signup', body };
  }

  @Post('login')
  @HttpCode(200)
  login(@Body() body: unknown) {
    return { message: 'Proxy to auth-service /auth/login', body };
  }

  @Post('refresh')
  @HttpCode(200)
  refresh(@Body() body: unknown) {
    return { message: 'Proxy to auth-service /auth/refresh', body };
  }

  @Post('logout')
  @HttpCode(204)
  logout(@Body() body: unknown) {
    return { message: 'Proxy to auth-service /auth/logout', body };
  }

  @Get('me')
  me(@Req() req: { headers: Record<string, string> }) {
    return { message: 'Proxy to auth-service /auth/me', authorization: req.headers?.authorization };
  }
}
