package com.example.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.DataProvider
import com.example.ui.MainUiState
import com.example.ui.MainViewModel
import com.example.ui.components.SectionCard
import com.example.ui.theme.*

@Composable
fun AboutAndSettingsScreen(
    uiState: MainUiState,
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        contentPadding = PaddingValues(top = 12.dp, bottom = 24.dp)
    ) {
        // Author Profile Hero Card
        item {
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = PrimaryNavy),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 14.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(56.dp)
                                .clip(CircleShape)
                                .background(
                                    Brush.linearGradient(
                                        listOf(AccentGold, AccentAmberLight, AccentTeal)
                                    )
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = "Author Avatar",
                                tint = Color.Black,
                                modifier = Modifier.size(32.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Column {
                            Text(
                                text = "Đàm Tường Quân",
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Text(
                                text = "Tác giả & Nhà phát triển chính",
                                style = MaterialTheme.typography.bodySmall,
                                color = AccentGold,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))
                    Divider(color = Color.White.copy(alpha = 0.15f))
                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "Thường trú: Thôn Đức Long 1 (Phia Tráng cũ), xã Nam Tuấn, tỉnh Cao Bằng",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(0xFFDCE6F2)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Nền tảng: Android Studio (Java, XML & Jetpack Compose)",
                        style = MaterialTheme.typography.bodySmall,
                        color = AccentTeal
                    )
                }
            }
        }

        // VIP Package Card
        item {
            SectionCard(
                title = "Đặc Quyền Gói VIP Premium 2026",
                subtitle = "12.000 lượt thao tác/ngày và mở khóa toàn bộ tính năng cao cấp",
                icon = Icons.Default.WorkspacePremium,
                badgeText = if (uiState.isPremium) "ĐANG KÍCH HOẠT" else "BẢN THƯỜNG",
                badgeColor = if (uiState.isPremium) AccentGold else Color.Gray
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    val benefits = listOf(
                        "✓ Không lo xuất hiện quảng cáo làm phiền",
                        "✓ Hạn mức thao tác nâng cao lên 12.000 lượt/ngày",
                        "✓ Mở khóa khôi phục dữ liệu game SimCity, Cities Skylines & City Island 6",
                        "✓ Xuất toàn bộ tài liệu hướng dẫn LEGO (.zip), tài liệu A4 (.pdf), danh bạ (.csv)",
                        "✓ Giả lập máy ảo cấu hình cao (tới 48 GB RAM & 2048 GB ROM, đồ họa 2K/4K)"
                    )

                    benefits.forEach { b ->
                        Text(text = b, fontSize = 13.sp, color = MaterialTheme.colorScheme.onSurface)
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Button(
                        onClick = { viewModel.togglePremium() },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (uiState.isPremium) PrimaryLightBlue else AccentGold
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("btn_toggle_vip_settings")
                    ) {
                        Icon(
                            imageVector = if (uiState.isPremium) Icons.Default.Check else Icons.Default.Stars,
                            contentDescription = null,
                            tint = if (uiState.isPremium) Color.White else Color.Black
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = if (uiState.isPremium) "Chuyển Sang Bản Miễn Phí (Free)" else "Kích Hoạt Đặc Quyền VIP (12.000 Lượt)",
                            color = if (uiState.isPremium) Color.White else Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }

        // Sound Effects & Settings Card
        item {
            SectionCard(
                title = "Cài Đặt Hệ Thống & Âm Thanh",
                subtitle = "Tùy chỉnh hệ thống phản hồi âm thanh Web Audio API",
                icon = Icons.Default.Tune,
                badgeText = "Âm Thanh"
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Bật âm thanh phản hồi thao tác:")
                        Switch(
                            checked = uiState.soundEffectsEnabled,
                            onCheckedChange = { viewModel.toggleSoundEffects() }
                        )
                    }

                    Column {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Âm lượng hệ thống:", fontSize = 13.sp)
                            Text("${(uiState.audioVolume * 100).toInt()}%", fontWeight = FontWeight.Bold, color = AccentGold)
                        }
                        Slider(
                            value = uiState.audioVolume,
                            onValueChange = { viewModel.setAudioVolume(it) },
                            valueRange = 0f..1f,
                            colors = SliderDefaults.colors(
                                thumbColor = AccentGold,
                                activeTrackColor = AccentGold
                            )
                        )
                    }
                }
            }
        }

        // Project History / Changelog Card
        item {
            SectionCard(
                title = "Lịch Sử Nâng Cấp & Tối Ưu Hóa Bộ Cài",
                subtitle = "Từ 480 MB tinh gọn xuống 275 MB chuẩn",
                icon = Icons.Default.Timeline,
                badgeText = "Changelog"
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    DataProvider.projectChangelog.forEach { milestone ->
                        Surface(
                            shape = RoundedCornerShape(10.dp),
                            color = MaterialTheme.colorScheme.surfaceVariant,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(12.dp)) {
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(
                                        text = "${milestone.version} (${milestone.date})",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 13.sp,
                                        color = AccentGold
                                    )
                                    Surface(
                                        shape = RoundedCornerShape(4.dp),
                                        color = PrimaryNavy
                                    ) {
                                        Text(
                                            text = "${milestone.apkSizeMB} MB",
                                            color = Color.White,
                                            fontSize = 10.sp,
                                            fontWeight = FontWeight.Bold,
                                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = milestone.title,
                                    style = MaterialTheme.typography.titleSmall,
                                    fontWeight = FontWeight.SemiBold,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = milestone.detail,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
