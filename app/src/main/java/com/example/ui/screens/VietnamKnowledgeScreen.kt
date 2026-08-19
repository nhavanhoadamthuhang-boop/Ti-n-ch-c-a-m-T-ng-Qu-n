package com.example.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.DataProvider
import com.example.model.AlphabetLetter
import com.example.ui.MainUiState
import com.example.ui.MainViewModel
import com.example.ui.components.SectionCard
import com.example.ui.theme.*

@Composable
fun VietnamKnowledgeScreen(
    uiState: MainUiState,
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var selectedCategory by remember { mutableStateOf(5) } // Default to newly added Sở Thú & Safari (5)
    // 0: Bác Hồ, 1: Tiếng Việt 1, 2: Hạ Tầng, 3: Ruộng Bậc Thang, 4: Vườn Quốc Gia, 5: Sở Thú & Safari, 6: Cảng & Dầu Khí, 7: Bệnh Viện, 8: Địa Danh, 9: Thiên Văn

    val categoryTabs = listOf(
        "Bác Hồ",
        "Tiếng Việt 1",
        "Hạ Tầng",
        "Ruộng Bậc Thang",
        "Vườn Quốc Gia",
        "Sở Thú & Safari",
        "Cảng & Dầu Khí",
        "Bệnh Viện",
        "Địa Danh",
        "Thiên Văn"
    )

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        contentPadding = PaddingValues(top = 12.dp, bottom = 24.dp)
    ) {
        item {
            // Horizontal scrollable Category Chips
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
            ) {
                items(categoryTabs.indices.toList()) { index ->
                    val isSelected = selectedCategory == index
                    FilterChip(
                        selected = isSelected,
                        onClick = { selectedCategory = index },
                        label = {
                            Text(
                                text = categoryTabs[index],
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                fontSize = 12.sp
                            )
                        },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = AccentGold.copy(alpha = 0.2f),
                            selectedLabelColor = AccentGold
                        )
                    )
                }
            }
        }

        if (selectedCategory == 0) {
            // UNCLE HO & 5 TEACHINGS
            item {
                SectionCard(
                    title = "5 Điều Bác Hồ Dạy Thiếu Niên Nhi Đồng",
                    subtitle = "Bài học đạo đức thiêng liêng lưu truyền",
                    icon = Icons.Default.Star,
                    badgeText = "Widget Màn Hình",
                    badgeColor = AccentRed
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        DataProvider.uncleHo5Teachings.forEach { teaching ->
                            Surface(
                                shape = RoundedCornerShape(10.dp),
                                color = MaterialTheme.colorScheme.surfaceVariant,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.padding(12.dp)
                                ) {
                                    Icon(
                                        Icons.Default.BookmarkBorder,
                                        contentDescription = null,
                                        tint = AccentGold,
                                        modifier = Modifier.size(20.dp)
                                    )
                                    Spacer(modifier = Modifier.width(10.dp))
                                    Text(
                                        text = teaching,
                                        style = MaterialTheme.typography.bodyMedium,
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colorScheme.onSurface
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        Button(
                            onClick = {
                                Toast.makeText(context, "Đã ghim Tiện ích 5 Điều Bác Dạy ra Màn hình chính (Home Widget)!", Toast.LENGTH_SHORT).show()
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = PrimaryNavy),
                            modifier = Modifier
                                .fillMaxWidth()
                                .testTag("btn_pin_uncle_ho_widget")
                        ) {
                            Icon(Icons.Default.Widgets, contentDescription = null, tint = Color.White)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Ghim Tiện Ích (Widget) Lên Màn Hình Chính", color = Color.White)
                        }
                    }
                }
            }

            item {
                SectionCard(
                    title = "Dòng Thời Gian Chủ Tịch Hồ Chí Minh",
                    subtitle = "Lịch sử và tọa độ di tích địa chỉ đỏ",
                    icon = Icons.Default.HistoryEdu,
                    badgeText = "Địa Chỉ Đỏ",
                    badgeColor = AccentGold
                ) {
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        items(DataProvider.uncleHoTimeline.indices.toList()) { index ->
                            val item = DataProvider.uncleHoTimeline[index]
                            val isSelected = uiState.selectedUncleHoMilestoneIndex == index
                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = if (isSelected) AccentGold else MaterialTheme.colorScheme.surfaceVariant,
                                modifier = Modifier
                                    .clickable { viewModel.selectUncleHoMilestone(index) }
                                    .padding(vertical = 4.dp)
                            ) {
                                Text(
                                    text = item.year,
                                    color = if (isSelected) Color.Black else MaterialTheme.colorScheme.onSurface,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp,
                                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp)
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    val selectedItem = DataProvider.uncleHoTimeline[uiState.selectedUncleHoMilestoneIndex]
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(14.dp)) {
                            Text(
                                text = "${selectedItem.year} - ${selectedItem.title}",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = AccentGold
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Địa điểm: ${selectedItem.location}",
                                style = MaterialTheme.typography.bodySmall,
                                fontWeight = FontWeight.SemiBold,
                                color = AccentTeal
                            )
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                text = selectedItem.description,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(Icons.Default.Explore, contentDescription = null, tint = AccentGold, modifier = Modifier.size(16.dp))
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = selectedItem.coordinateNote,
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }
                }
            }
        } else if (selectedCategory == 1) {
            // VIETNAMESE ALPHABET GRADE 1
            item {
                SectionCard(
                    title = "Sách Tiếng Việt Lớp 1 - Bộ Chuẩn GD&ĐT",
                    subtitle = "29 chữ cái, 6 thanh điệu, 11 phụ âm và 144 vần ghép",
                    icon = Icons.Default.Spellcheck,
                    badgeText = "Phát Âm Chuẩn"
                ) {
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = PrimaryNavy,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Box(
                                    modifier = Modifier
                                        .size(60.dp)
                                        .clip(CircleShape)
                                        .background(AccentGold),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = uiState.selectedLetter.letter,
                                        color = Color.Black,
                                        fontWeight = FontWeight.ExtraBold,
                                        fontSize = 28.sp
                                    )
                                }
                                Spacer(modifier = Modifier.width(14.dp))
                                Column {
                                    Text(
                                        text = "Từ ví dụ: ${uiState.selectedLetter.exampleWord}",
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 16.sp
                                    )
                                    Text(
                                        text = uiState.selectedLetter.meaning,
                                        color = TextSecondaryDark,
                                        fontSize = 12.sp
                                    )
                                    Text(
                                        text = "Phiên âm: ${uiState.selectedLetter.phonetic}",
                                        color = AccentTeal,
                                        fontSize = 12.sp,
                                        fontFamily = androidx.compose.ui.text.font.FontFamily.Monospace
                                    )
                                }
                            }

                            IconButton(
                                onClick = { viewModel.selectAlphabetLetter(uiState.selectedLetter) },
                                modifier = Modifier
                                    .size(44.dp)
                                    .clip(CircleShape)
                                    .background(AccentGold.copy(alpha = 0.2f))
                            ) {
                                Icon(
                                    imageVector = if (uiState.spokenLetterAudioActive) Icons.Default.GraphicEq else Icons.Default.VolumeUp,
                                    contentDescription = "Pronounce",
                                    tint = AccentGold
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))
                    Text("Bảng 29 chữ cái (Chạm để nghe phát âm):", fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
                    Spacer(modifier = Modifier.height(8.dp))

                    val chunks = DataProvider.vietnameseAlphabet.chunked(6)
                    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        chunks.forEach { rowLetters ->
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(6.dp),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                rowLetters.forEach { letterItem ->
                                    val isSelected = uiState.selectedLetter.letter == letterItem.letter
                                    Surface(
                                        shape = RoundedCornerShape(8.dp),
                                        color = if (isSelected) AccentGold else MaterialTheme.colorScheme.surfaceVariant,
                                        modifier = Modifier
                                            .weight(1f)
                                            .clickable { viewModel.selectAlphabetLetter(letterItem) }
                                    ) {
                                        Box(
                                            contentAlignment = Alignment.Center,
                                            modifier = Modifier.padding(vertical = 10.dp)
                                        ) {
                                            Text(
                                                text = letterItem.letter,
                                                fontWeight = FontWeight.Bold,
                                                fontSize = 15.sp,
                                                color = if (isSelected) Color.Black else MaterialTheme.colorScheme.onSurface
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    OutlinedButton(
                        onClick = {
                            Toast.makeText(context, "Đã tải xuống trọn bộ Bảng chữ cái và 144 vần ghép (.pdf)!", Toast.LENGTH_SHORT).show()
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(Icons.Default.PictureAsPdf, contentDescription = null, tint = AccentRed)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Tải Trọn Bộ Bảng Chữ Cái & 144 Vần Ghép (.pdf)")
                    }
                }
            }
        } else if (selectedCategory == 2) {
            // INFRASTRUCTURE, TRANSPORTATION & TOURISM
            item {
                var selectedInfraSubCategory by remember { mutableStateOf("Tất cả") }
                val subCategories = listOf("Tất cả", "Cao tốc", "Đường sắt", "Cầu", "Hầm", "Cáp treo", "Đèo", "Cửa khẩu", "Hàng không")

                SectionCard(
                    title = "Địa Lý, Giao Thông & Du Lịch Việt Nam",
                    subtitle = "Mạng lưới cao tốc, đường sắt metro, cầu hầm vượt biển, cáp treo, tứ đại đỉnh đèo & tuyến bay",
                    icon = Icons.Default.AltRoute,
                    badgeText = "Hạ Tầng & Du Lịch"
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        // Sub-category filters
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(6.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            items(subCategories) { cat ->
                                val isSelected = selectedInfraSubCategory == cat
                                FilterChip(
                                    selected = isSelected,
                                    onClick = { selectedInfraSubCategory = cat },
                                    label = { Text(cat, fontSize = 11.sp) },
                                    colors = FilterChipDefaults.filterChipColors(
                                        selectedContainerColor = AccentGold.copy(alpha = 0.2f),
                                        selectedLabelColor = AccentGold
                                    )
                                )
                            }
                        }

                        val filteredList = DataProvider.infrastructureList.filter {
                            if (selectedInfraSubCategory == "Tất cả") true
                            else it.category.contains(selectedInfraSubCategory, ignoreCase = true)
                        }

                        filteredList.forEach { infra ->
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
                                            text = infra.title,
                                            style = MaterialTheme.typography.titleSmall,
                                            fontWeight = FontWeight.Bold,
                                            color = MaterialTheme.colorScheme.onSurface,
                                            modifier = Modifier.weight(1f)
                                        )
                                        Surface(
                                            shape = RoundedCornerShape(4.dp),
                                            color = PrimaryNavy
                                        ) {
                                            Text(
                                                text = infra.category,
                                                color = AccentGold,
                                                fontSize = 9.sp,
                                                fontWeight = FontWeight.Bold,
                                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                            )
                                        }
                                    }
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = "📍 ${infra.routeLocation}",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = AccentTeal,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                    Spacer(modifier = Modifier.height(2.dp))
                                    Text(
                                        text = "📏 Thông số: ${infra.lengthOrSpec}",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = AccentAmberLight
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = infra.highlight,
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            OutlinedButton(
                                onClick = {
                                    Toast.makeText(context, "Đã phát âm thanh mô phỏng còi tàu Thống Nhất & Thông báo ga Bến Thành!", Toast.LENGTH_SHORT).show()
                                },
                                modifier = Modifier.weight(1f)
                            ) {
                                Icon(Icons.Default.VolumeUp, contentDescription = null, tint = AccentGold)
                                Spacer(modifier = Modifier.width(6.dp))
                                Text("Âm Thanh Còi Tàu", fontSize = 11.sp)
                            }

                            Button(
                                onClick = {
                                    Toast.makeText(context, "Đã kích hoạt Bản đồ định tuyến & Cảnh báo an toàn hầm/đèo thời gian thực!", Toast.LENGTH_SHORT).show()
                                },
                                colors = ButtonDefaults.buttonColors(containerColor = PrimaryNavy),
                                modifier = Modifier.weight(1f)
                            ) {
                                Icon(Icons.Default.Navigation, contentDescription = null, tint = Color.White)
                                Spacer(modifier = Modifier.width(6.dp))
                                Text("Lộ Trình Du Lịch", fontSize = 11.sp, color = Color.White)
                            }
                        }
                    }
                }
            }
        } else if (selectedCategory == 3) {
            // FAMOUS TERRACED FIELDS IN VIETNAM
            item {
                var selectedSeasonFilter by remember { mutableStateOf("Tất cả") }
                val seasonOptions = listOf("Tất cả", "Yên Bái", "Hà Giang", "Lào Cai", "Cao Bằng", "Thanh Hóa", "Tuyên Quang")

                SectionCard(
                    title = "Ruộng Bậc Thang Nổi Tiếng Việt Nam",
                    subtitle = "Kiệt tác canh tác lúa nước trên sườn núi & Di tích Quốc gia Đặc biệt",
                    icon = Icons.Default.Landscape,
                    badgeText = "Di Tích & Danh Thắng",
                    badgeColor = AccentGold
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        // Location Filter Chips
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(6.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            items(seasonOptions) { loc ->
                                val isSelected = selectedSeasonFilter == loc
                                FilterChip(
                                    selected = isSelected,
                                    onClick = { selectedSeasonFilter = loc },
                                    label = { Text(loc, fontSize = 11.sp) },
                                    colors = FilterChipDefaults.filterChipColors(
                                        selectedContainerColor = AccentGold.copy(alpha = 0.2f),
                                        selectedLabelColor = AccentGold
                                    )
                                )
                            }
                        }

                        val filteredTerraced = DataProvider.terracedFieldsList.filter {
                            if (selectedSeasonFilter == "Tất cả") true
                            else it.province.contains(selectedSeasonFilter, ignoreCase = true)
                        }

                        filteredTerraced.forEach { tf ->
                            Surface(
                                shape = RoundedCornerShape(12.dp),
                                color = MaterialTheme.colorScheme.surfaceVariant,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Column(modifier = Modifier.padding(14.dp)) {
                                    Row(
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Text(
                                            text = tf.name,
                                            style = MaterialTheme.typography.titleMedium,
                                            fontWeight = FontWeight.Bold,
                                            color = AccentGold,
                                            modifier = Modifier.weight(1f)
                                        )
                                        Surface(
                                            shape = RoundedCornerShape(4.dp),
                                            color = PrimaryNavy
                                        ) {
                                            Text(
                                                text = tf.province,
                                                color = Color.White,
                                                fontSize = 10.sp,
                                                fontWeight = FontWeight.Bold,
                                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                            )
                                        }
                                    }

                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = "🏆 ${tf.nationalHeritageStatus}",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = AccentAmberLight,
                                        fontWeight = FontWeight.SemiBold
                                    )

                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = "🌾 Quy mô: ${tf.areaHectares}",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = AccentTeal
                                    )

                                    Spacer(modifier = Modifier.height(2.dp))
                                    Text(
                                        text = "☀️ Thời điểm đẹp nhất: ${tf.bestSeason}",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = SuccessGreen,
                                        fontWeight = FontWeight.Medium
                                    )

                                    Spacer(modifier = Modifier.height(2.dp))
                                    Text(
                                        text = "👥 Dân tộc cư trú: ${tf.ethnicGroups}",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )

                                    Spacer(modifier = Modifier.height(6.dp))
                                    Text(
                                        text = tf.highlights,
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.onSurface
                                    )

                                    Spacer(modifier = Modifier.height(6.dp))
                                    Surface(
                                        shape = RoundedCornerShape(6.dp),
                                        color = PrimaryNavy.copy(alpha = 0.5f),
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp)
                                        ) {
                                            Icon(Icons.Default.PhotoCamera, contentDescription = null, tint = AccentGold, modifier = Modifier.size(16.dp))
                                            Spacer(modifier = Modifier.width(6.dp))
                                            Text(
                                                text = "Điểm check-in đẹp: ${tf.famousSpots}",
                                                fontSize = 11.sp,
                                                color = Color.White
                                            )
                                        }
                                    }
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        Button(
                            onClick = {
                                Toast.makeText(context, "Đã lên lịch trình khám phá Mùa Lúa Chín & Mùa Nước Đổ Đông - Tây Bắc!", Toast.LENGTH_SHORT).show()
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = PrimaryNavy),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(Icons.Default.Tour, contentDescription = null, tint = Color.White)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Lên Kế Hoạch Khám Phá Mùa Vàng Tây Bắc", color = Color.White)
                        }
                    }
                }
            }
        } else if (selectedCategory == 4) {
            // FAMOUS NATIONAL PARKS IN VIETNAM
            item {
                var selectedParkRegion by remember { mutableStateOf("Tất cả") }
                val parkRegions = listOf("Tất cả", "Miền Bắc", "Miền Trung", "Miền Nam", "Cao Bằng", "UNESCO / Ramsar")

                SectionCard(
                    title = "Vườn Quốc Gia Nổi Tiếng Việt Nam",
                    subtitle = "Di sản Thiên nhiên Thế giới, Khu Ramsar và bảo tồn đa dạng sinh học",
                    icon = Icons.Default.Forest,
                    badgeText = "Bảo Tồn Thiên Nhiên",
                    badgeColor = SuccessGreen
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        // Region Filters
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(6.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            items(parkRegions) { reg ->
                                val isSelected = selectedParkRegion == reg
                                FilterChip(
                                    selected = isSelected,
                                    onClick = { selectedParkRegion = reg },
                                    label = { Text(reg, fontSize = 11.sp) },
                                    colors = FilterChipDefaults.filterChipColors(
                                        selectedContainerColor = SuccessGreen.copy(alpha = 0.2f),
                                        selectedLabelColor = SuccessGreen
                                    )
                                )
                            }
                        }

                        val filteredParks = DataProvider.nationalParksList.filter {
                            when (selectedParkRegion) {
                                "Tất cả" -> true
                                "UNESCO / Ramsar" -> it.unescoRamsarTitle.contains("UNESCO") || it.unescoRamsarTitle.contains("Ramsar")
                                "Cao Bằng" -> it.province.contains("Cao Bằng")
                                else -> it.region.contains(selectedParkRegion, ignoreCase = true)
                            }
                        }

                        filteredParks.forEach { park ->
                            Surface(
                                shape = RoundedCornerShape(12.dp),
                                color = MaterialTheme.colorScheme.surfaceVariant,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Column(modifier = Modifier.padding(14.dp)) {
                                    Row(
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Text(
                                            text = park.name,
                                            style = MaterialTheme.typography.titleMedium,
                                            fontWeight = FontWeight.Bold,
                                            color = AccentGold,
                                            modifier = Modifier.weight(1f)
                                        )
                                        Surface(
                                            shape = RoundedCornerShape(4.dp),
                                            color = PrimaryNavy
                                        ) {
                                            Text(
                                                text = park.region,
                                                color = Color.White,
                                                fontSize = 10.sp,
                                                fontWeight = FontWeight.Bold,
                                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                            )
                                        }
                                    }

                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = "📍 Địa bàn: ${park.province} • Diện tích: ${park.areaHectares}",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = AccentTeal,
                                        fontWeight = FontWeight.SemiBold
                                    )

                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = "🏅 Danh hiệu: ${park.unescoRamsarTitle}",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = AccentAmberLight,
                                        fontWeight = FontWeight.Medium
                                    )

                                    Spacer(modifier = Modifier.height(3.dp))
                                    Text(
                                        text = "🐾 Sinh vật biểu tượng: ${park.iconicFloraFauna}",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = SuccessGreen
                                    )

                                    Spacer(modifier = Modifier.height(6.dp))
                                    Text(
                                        text = park.highlights,
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.onSurface
                                    )

                                    Spacer(modifier = Modifier.height(6.dp))
                                    Surface(
                                        shape = RoundedCornerShape(6.dp),
                                        color = PrimaryNavy.copy(alpha = 0.5f),
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp)
                                        ) {
                                            Icon(Icons.Default.NaturePeople, contentDescription = null, tint = AccentGold, modifier = Modifier.size(16.dp))
                                            Spacer(modifier = Modifier.width(6.dp))
                                            Text(
                                                text = "Điểm tham quan: ${park.ecotourismSpots}",
                                                fontSize = 11.sp,
                                                color = Color.White
                                            )
                                        }
                                    }
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        Button(
                            onClick = {
                                Toast.makeText(context, "Đã mở hướng dẫn Bản đồ sinh thái & Đăng ký tour Trekking Vườn Quốc Gia!", Toast.LENGTH_SHORT).show()
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = SuccessGreen),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(Icons.Default.Explore, contentDescription = null, tint = Color.Black)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Bản Đồ Sinh Thái & Trekking Rừng Nguyên Sinh", color = Color.Black, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        } else if (selectedCategory == 5) {
            // ==========================================
            // FAMOUS ZOOS & SAFARI PARKS IN VIETNAM
            // ==========================================
            item {
                var selectedZooFilter by remember { mutableStateOf("Tất cả") }
                val zooFilterOptions = listOf("Tất cả", "Miền Bắc", "Miền Trung", "Miền Nam", "Safari Bán Hoang Dã", "Vườn Thú Thân Thiện")

                SectionCard(
                    title = "Sở Thú & Safari Nổi Tiếng Việt Nam",
                    subtitle = "Thảo Cầm Viên lịch sử, Vinpearl Safari, River Safari sông nước & Petting Zoo",
                    icon = Icons.Default.Pets,
                    badgeText = "Sở Thú & Safari",
                    badgeColor = AccentGold
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        // Category Filters
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(6.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            items(zooFilterOptions) { filter ->
                                val isSelected = selectedZooFilter == filter
                                FilterChip(
                                    selected = isSelected,
                                    onClick = { selectedZooFilter = filter },
                                    label = { Text(filter, fontSize = 11.sp) },
                                    colors = FilterChipDefaults.filterChipColors(
                                        selectedContainerColor = AccentGold.copy(alpha = 0.2f),
                                        selectedLabelColor = AccentGold
                                    )
                                )
                            }
                        }

                        val filteredZoos = DataProvider.zoosList.filter {
                            when (selectedZooFilter) {
                                "Tất cả" -> true
                                "Safari Bán Hoang Dã" -> it.type.contains("Safari", ignoreCase = true)
                                "Vườn Thú Thân Thiện" -> it.type.contains("Thân Thiện", ignoreCase = true) || it.name.contains("Zoodoo", ignoreCase = true)
                                else -> it.region.contains(selectedZooFilter, ignoreCase = true)
                            }
                        }

                        filteredZoos.forEach { zoo ->
                            Surface(
                                shape = RoundedCornerShape(12.dp),
                                color = MaterialTheme.colorScheme.surfaceVariant,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Column(modifier = Modifier.padding(14.dp)) {
                                    Row(
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Text(
                                            text = zoo.name,
                                            style = MaterialTheme.typography.titleMedium,
                                            fontWeight = FontWeight.Bold,
                                            color = AccentGold,
                                            modifier = Modifier.weight(1f)
                                        )
                                        Surface(
                                            shape = RoundedCornerShape(4.dp),
                                            color = PrimaryNavy
                                        ) {
                                            Text(
                                                text = zoo.region,
                                                color = Color.White,
                                                fontSize = 10.sp,
                                                fontWeight = FontWeight.Bold,
                                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                            )
                                        }
                                    }

                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = "🏷️ Mô hình: ${zoo.type}",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = AccentAmberLight,
                                        fontWeight = FontWeight.SemiBold
                                    )

                                    Spacer(modifier = Modifier.height(3.dp))
                                    Text(
                                        text = "📍 Địa điểm: ${zoo.province} • Quy mô: ${zoo.areaHectares}",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = AccentTeal,
                                        fontWeight = FontWeight.Medium
                                    )

                                    Spacer(modifier = Modifier.height(3.dp))
                                    Text(
                                        text = "🦁 Số lượng động vật: ${zoo.totalSpeciesAndAnimals}",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = MaterialTheme.colorScheme.onSurface
                                    )

                                    Spacer(modifier = Modifier.height(3.dp))
                                    Text(
                                        text = "🐾 Động vật tiêu biểu: ${zoo.iconicAnimals}",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = SuccessGreen,
                                        fontWeight = FontWeight.SemiBold
                                    )

                                    Spacer(modifier = Modifier.height(6.dp))
                                    Text(
                                        text = zoo.highlights,
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )

                                    Spacer(modifier = Modifier.height(6.dp))
                                    Surface(
                                        shape = RoundedCornerShape(6.dp),
                                        color = PrimaryNavy.copy(alpha = 0.5f),
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp)
                                        ) {
                                            Icon(Icons.Default.Star, contentDescription = null, tint = AccentGold, modifier = Modifier.size(16.dp))
                                            Spacer(modifier = Modifier.width(6.dp))
                                            Text(
                                                text = "Trải nghiệm đặc sắc: ${zoo.famousExperiences}",
                                                fontSize = 11.sp,
                                                color = Color.White
                                            )
                                        }
                                    }
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        Button(
                            onClick = {
                                Toast.makeText(context, "Đã mở Cẩm nang hướng dẫn tham quan Safari & Lịch biểu diễn động vật!", Toast.LENGTH_SHORT).show()
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = PrimaryNavy),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(Icons.Default.ConfirmationNumber, contentDescription = null, tint = Color.White)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Cẩm Nang Tham Quan Safari & Lịch Biểu Diễn", color = Color.White)
                        }
                    }
                }
            }
        } else if (selectedCategory == 6) {
            // PORTS, FISHING HARBORS & OIL FACILITIES
            item {
                SectionCard(
                    title = "Bến Thuyền, Cảng Cá & Cụm Dầu Mỏ Việt Nam",
                    subtitle = "Hệ thống cảng nước sâu, ngư trường và an ninh năng lượng",
                    icon = Icons.Default.DirectionsBoat,
                    badgeText = "Cảng Biển & Năng Lượng",
                    badgeColor = AccentTeal
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        DataProvider.portsAndEnergyList.forEach { port ->
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
                                            text = port.name,
                                            style = MaterialTheme.typography.titleSmall,
                                            fontWeight = FontWeight.Bold,
                                            color = MaterialTheme.colorScheme.onSurface,
                                            modifier = Modifier.weight(1f)
                                        )
                                        Surface(
                                            shape = RoundedCornerShape(4.dp),
                                            color = PrimaryLightBlue
                                        ) {
                                            Text(
                                                text = port.type,
                                                color = Color.White,
                                                fontSize = 9.sp,
                                                fontWeight = FontWeight.Bold,
                                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                            )
                                        }
                                    }
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = "📍 Địa điểm: ${port.location} • ⚓ ${port.capacity}",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = AccentGold,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = port.description,
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }
                        }
                    }
                }
            }
        } else if (selectedCategory == 7) {
            // HOSPITALS IN VIETNAM
            item {
                SectionCard(
                    title = "Hệ Thống Bệnh Viện Trọng Điểm Việt Nam",
                    subtitle = "Bệnh viện Hạng Đặc biệt, Tuyến Trung ương và Tuyến Tỉnh",
                    icon = Icons.Default.LocalHospital,
                    badgeText = "Y Tế Quốc Gia",
                    badgeColor = AccentRed
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        DataProvider.hospitalsList.forEach { hospital ->
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
                                            text = hospital.name,
                                            style = MaterialTheme.typography.titleSmall,
                                            fontWeight = FontWeight.Bold,
                                            color = MaterialTheme.colorScheme.onSurface,
                                            modifier = Modifier.weight(1f)
                                        )
                                        Surface(
                                            shape = RoundedCornerShape(4.dp),
                                            color = AccentRed.copy(alpha = 0.15f)
                                        ) {
                                            Text(
                                                text = hospital.level,
                                                color = AccentRed,
                                                fontSize = 9.sp,
                                                fontWeight = FontWeight.Bold,
                                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                            )
                                        }
                                    }
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = "🏥 Địa chỉ: ${hospital.location}",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = AccentTeal,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = "Chuyên khoa mũi nhọn: ${hospital.specialties}",
                                        style = MaterialTheme.typography.bodyMedium,
                                        fontWeight = FontWeight.Medium,
                                        color = MaterialTheme.colorScheme.onSurface
                                    )
                                    Spacer(modifier = Modifier.height(2.dp))
                                    Text(
                                        text = hospital.scaleBeds,
                                        style = MaterialTheme.typography.labelSmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }
                        }
                    }
                }
            }
        } else if (selectedCategory == 8) {
            // FAMOUS LANDMARKS IN VIETNAM & WORLDWIDE
            item {
                SectionCard(
                    title = "Công Trình Nổi Tiếng Việt Nam & Địa Danh Thế Giới",
                    subtitle = "Kiệt tác kiến trúc, Di sản UNESCO và Kỳ quan nhân loại",
                    icon = Icons.Default.AccountBalance,
                    badgeText = "UNESCO & Kỳ Quan",
                    badgeColor = AccentGold
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        DataProvider.famousLandmarksList.forEach { landmark ->
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
                                            text = landmark.name,
                                            style = MaterialTheme.typography.titleSmall,
                                            fontWeight = FontWeight.Bold,
                                            color = MaterialTheme.colorScheme.onSurface,
                                            modifier = Modifier.weight(1f)
                                        )
                                        Surface(
                                            shape = RoundedCornerShape(4.dp),
                                            color = PrimaryNavy
                                        ) {
                                            Text(
                                                text = landmark.region,
                                                color = AccentGold,
                                                fontSize = 9.sp,
                                                fontWeight = FontWeight.Bold,
                                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                            )
                                        }
                                    }
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = "🌍 Vị trí: ${landmark.country} • Kiến trúc: ${landmark.architecturalStyle}",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = AccentTeal,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = landmark.significance,
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }
                        }
                    }
                }
            }
        } else {
            // ASTRONOMY & HOROSCOPE
            item {
                SectionCard(
                    title = "Thiên Văn Học & Chu Kỳ Mặt Trời - Mặt Trăng",
                    subtitle = "Định vị GPS thực tế và la bàn số",
                    icon = Icons.Default.WbSunny,
                    badgeText = "GPS Thiên Văn",
                    badgeColor = AccentGold
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column {
                                Text("Mặt trời mọc:", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                                Text(uiState.solarLunarData.sunrise, fontWeight = FontWeight.Bold, color = AccentGold)
                            }
                            Column {
                                Text("Mặt trời lặn:", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                                Text(uiState.solarLunarData.sunset, fontWeight = FontWeight.Bold, color = AccentRed)
                            }
                            Column {
                                Text("Góc La Bàn:", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                                Text("${uiState.solarLunarData.compassAzimuth}° ĐB", fontWeight = FontWeight.Bold, color = AccentTeal)
                            }
                        }
                        Divider(color = MaterialTheme.colorScheme.surfaceVariant)
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Chu kỳ trăng hiện tại:", fontSize = 13.sp)
                            Text(uiState.solarLunarData.moonPhase, fontWeight = FontWeight.Bold, color = AccentAmberLight)
                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Độ sáng phản chiếu:", fontSize = 13.sp)
                            Text(uiState.solarLunarData.illumination, fontWeight = FontWeight.Bold, color = SuccessGreen)
                        }
                    }
                }
            }

            item {
                SectionCard(
                    title = "Tử Vi Số Hóa 12 Con Giáp & Mã TVxxxxxxxx",
                    subtitle = "Tra cứu vận hạn và tạo mã kích hoạt khẩn cấp",
                    icon = Icons.Default.Psychology,
                    badgeText = "Tử Vi 2026"
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column {
                                Text("Mã kích hoạt tra cứu tử vi:", fontSize = 12.sp)
                                Text(uiState.generatedTvCode, fontWeight = FontWeight.ExtraBold, fontSize = 18.sp, color = AccentGold)
                            }
                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = PrimaryNavy
                            ) {
                                Text(
                                    text = "+${uiState.tvCodeUsesLeft} lượt",
                                    color = Color.White,
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                )
                            }
                        }

                        Button(
                            onClick = { viewModel.generateNewTvCode() },
                            colors = ButtonDefaults.buttonColors(containerColor = PrimaryNavy),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(Icons.Default.AutoAwesome, contentDescription = null, tint = AccentGold)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Tạo Mã Tử Vi TVxxxxxxxx Mới", color = Color.White)
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        Text("Luận giải 12 con giáp năm 2026:", fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
                        DataProvider.horoscopeZodiac.take(4).forEach { (zodiac, forecast) ->
                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = MaterialTheme.colorScheme.surfaceVariant,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Column(modifier = Modifier.padding(10.dp)) {
                                    Text(zodiac, fontWeight = FontWeight.Bold, fontSize = 13.sp, color = AccentTeal)
                                    Text(forecast, fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
